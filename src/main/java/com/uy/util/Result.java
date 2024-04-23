package com.uy.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static final class Builder<T> {
        private int code;
        private String message;
        private T data;

        private Builder() {

        }

        public Builder code(int val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder data(T val) {
            data = val;
            return this;
        }

        public Result build() {
            return new Result(this.code,this.message,this.data);
        }
    }

}

