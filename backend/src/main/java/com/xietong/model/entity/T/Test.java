package com.xietong.model.entity.T;

import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @NonNull
    private int t1id;
    private int t1col;
    private List<Test2> test2;
}
