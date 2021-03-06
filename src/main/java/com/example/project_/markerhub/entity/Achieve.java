package com.example.project_.markerhub.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Achieve implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String content;

    private LocalDateTime time;

    private Integer hot;

    private String participantMember;

    private Integer sort;

    private String achieveName;


}
