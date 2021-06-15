package com.xietong.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-12 10:13
 */
@Data
public class MenuDTO implements Serializable {
    private Long id;

    private String code;
    private String title;
    private String icon;
    private String path;
    private String component;
    private List<MenuDTO> children = new ArrayList<>();
}
