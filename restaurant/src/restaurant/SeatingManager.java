package restaurant;

import java.util.List;

/**
 * Table seating for customer groups (basic thread safe)
 *
 * Carlos Saltos 29/10/12 15:39
 */
public class SeatingManager {

    private List<Table> tables;

    public SeatingManager(List<Table> tables) {
        this.tables = tables;
    }

    public boolean arrives(CustomerGroup group) {
        if (tables == null || tables.isEmpty()) {
            throw new IllegalStateException("Unable to seat the customer group at non existent tables");
        }
        if (group == null) {
            throw new IllegalStateException("Unable to seat a null group");
        }
        if (group.getAssignedTable() != null) {
            throw new IllegalStateException("Unable to seat a group with an already assigned table");
        }
        // look for an available table to assign
        synchronized (this.tables) {
            Table assignableTable = null;
            for (Table table: tables) {
                  if (table.hasAvailableSeats(group.getSize())) {
                      if (assignableTable == null) {
                        assignableTable = table;
                      } else if (table.getSize() < assignableTable.getSize()) {
                          assignableTable = table;
                      }
                   }
            }
            if (assignableTable == null) {
                // no table available
                return false;
            }
            assignableTable.assignSeats(group.getSize());
            group.setAssignedTable(assignableTable);
            return  true;
        }
    }

    public void leaves(CustomerGroup group) {
        if (group == null) {
            throw new IllegalStateException("Unable to leave a null group");
        }
        synchronized (this.tables) {
            group.leaveTable();
        }
    }

    public Table locate(CustomerGroup group) {
        if (group == null) {
            throw new IllegalStateException("Unable to locate a null group");
        }
        synchronized (this.tables) {
            return group.getAssignedTable();
        }
    }

}
