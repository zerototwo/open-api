package com.open.api.bo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test1BO implements Serializable {
    private static final long serialVersionUID = -1L;

    @Valid
    @NotEmpty(message = "集合不为空！")
    @Size(min = 1, message = "最小为{min}")
    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static class Item {
        @NotBlank(message = "username 不能为空！")
        private String username;

        @NotBlank(message = "password 不能为空！")
        private String password;

        @NotBlank(message = "realName 不能为空！")
        private String realName;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        List<Item> list = new ArrayList<>();
        item1.setUsername("lpp1");
        item1.setRealName("lupp");
        item1.setPassword("123456");

        item2.setUsername("lpp2");
        item2.setRealName("lup2");
        item2.setPassword("98765432");

        list.add(item1);
        list.add(item2);

        System.out.println(JSON.toJSONString(list));

    }
}