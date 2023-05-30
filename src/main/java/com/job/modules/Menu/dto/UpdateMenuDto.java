package com.job.modules.Menu.dto;

import com.job.entities.Menu;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateMenuDto extends Menu {
    private ArrayList<Integer> roleIds;
}
