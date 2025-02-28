package Exa;

import lombok.Data;

import java.util.List;

public class Orders
{
    private List<OrderDetail> orders;

    public List<OrderDetail> setOrders(List<OrderDetail> orderDetailList)
    {
        return orders;
    }

    @Data
    public static class OrderDetail
    {
        private String Country;
        private String ProductOrderedId;
    }

}
