package org.py.sweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = -973932003283779763L;
    private Long id;
    @NotEmpty(message = "必须填写文章标题")
    private String title;
    private String smallTitle;
    private String author;
    private String source;
    @NotNull(message = "资源ID不能为空")
    private Long resourceId;
    private LocalDateTime publishDatetime;
    private Boolean artLock;
    private String keyword;
    private String userGroup;
    private Integer clicks;
    private String thumbnail;
    private String album;
    @NotNull(message = "文章内容不能为空")
    private String content;
}
