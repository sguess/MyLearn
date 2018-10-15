package com.sguess.tmp;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() throws ParseException {
        List<Goods> list = getGoodsList();
        Set<Goods> rst = list.stream().collect(Collectors.toSet());
        System.out.println(rst.size());

        Set<String> stringRst = getStringList().stream().collect(Collectors.toSet());
        for (String s : stringRst) {
            System.out.println(s);
        }
    }

    private List<Goods> getGoodsList() throws ParseException {
        List<Goods> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        list.add(new Goods("c01", "n01", new BigDecimal("4.01"), simpleDateFormat.parse("20180809"), 501));
        list.add(new Goods("c02", "n02", new BigDecimal("4.02"), simpleDateFormat.parse("20180809"), 502));
        list.add(new Goods("c03", "n03", new BigDecimal("4.03"), simpleDateFormat.parse("20180809"), 503));
        list.add(new Goods("c04", "n04", new BigDecimal("4.04"), simpleDateFormat.parse("20180809"), 504));
        list.add(new Goods("c05", "n05", new BigDecimal("4.05"), simpleDateFormat.parse("20180809"), 505));
        list.add(new Goods("c06", "n06", new BigDecimal("4.06"), simpleDateFormat.parse("20180809"), 506));
        return list;
    }

    private List<String> getStringList() throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("A01");
        list.add("A01");
        list.add("A02");
        list.add("A03");
        list.add("A04");
        list.add("A05");
        list.add("A05");
        list.add("A06");
        return list;
    }
}

class Goods {
    private int id;
    private String code;
    private String name;
    private BigDecimal price;
    private Date productDate;
    private int weigth;

    public Goods() {
    }

    public Goods(String code, String name, BigDecimal price, Date productDate, int weigth) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.productDate = productDate;
        this.weigth = weigth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
}
