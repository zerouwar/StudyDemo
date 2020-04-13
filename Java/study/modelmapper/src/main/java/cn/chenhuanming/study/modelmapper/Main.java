package cn.chenhuanming.study.modelmapper;

import cn.chenhuanming.study.modelmapper.domain.Order;
import cn.chenhuanming.study.modelmapper.dto.OrderDTO;
import org.modelmapper.ModelMapper;

/**
 * @author guangdao
 * Created at 2019-04-22
 */
public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order("qw12da","computer");
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        System.out.println(orderDTO);

    }
}
