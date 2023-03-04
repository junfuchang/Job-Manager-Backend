package com.job.modules.Menu.vo;

import com.job.entities.Menu;
import lombok.Data;

import java.util.ArrayList;

@Data
public class SelectMenuListVo extends Menu {
    private ArrayList<Integer> roleIds;

}
