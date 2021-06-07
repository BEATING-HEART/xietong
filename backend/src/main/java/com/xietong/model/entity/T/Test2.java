package com.xietong.model.entity.T;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Test2 {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int t2id;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int t2col;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private  int t2col1;
}
