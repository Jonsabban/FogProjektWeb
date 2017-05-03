package main;

import classes.OrderLine;
import java.util.ArrayList;

public class CalcMethods {

    ArrayList<OrderLine> orders;
    int oID;
    int width;
    int length;

    public OrderLine understernFB() {

        OrderLine order = new OrderLine(oID, 1, (width / 2) + 60, 4, "test");
        orders.add(order);
        return order;

    }

    public OrderLine understernSide() {

        OrderLine order = new OrderLine(oID, 1, length, 4, "test");
        orders.add(order);
        return order;

    }

    public OrderLine oversternF() {

        OrderLine order = new OrderLine(oID, 2, (width / 2) + 60, 2, "test");
        orders.add(order);
        return order;

    }

    public OrderLine oversternSide() {

        OrderLine order = new OrderLine(oID, 2, length, 4, "test");
        orders.add(order);
        return order;

    }

    public OrderLine remmeSide() {

        OrderLine order = new OrderLine(oID, 5, length + 60, 2, "test");
        orders.add(order);
        return order;

    }

    public OrderLine bræddebolte() {

        OrderLine order = new OrderLine(oID, 16, 0, ((length + 60) / 100) * 3, "test");
        orders.add(order);
        return order;

    }

    public OrderLine firkantskiver() {

        OrderLine order = new OrderLine(oID, 17, 0, ((length + 60) / 100) * 2, "test");
        orders.add(order);
        return order;

    }

    public OrderLine spær() {

        OrderLine order = new OrderLine(oID, 1, 0, 0, "FEJL SKAL LAVES OM");
        orders.add(order);
        return order;

    }

}
