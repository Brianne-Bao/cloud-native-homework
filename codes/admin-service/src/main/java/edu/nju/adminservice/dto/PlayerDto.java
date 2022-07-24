package edu.nju.adminservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto
{

    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;
    /**
     * 位置
     */
    private String position;
    /**
     * 号码
     */
    private int number;

}
