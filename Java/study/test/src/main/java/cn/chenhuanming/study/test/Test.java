package cn.chenhuanming.study.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author guangdao
 * Created at 2019-05-13
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class Test {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Test.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    ObjectMapper objectMapper = new ObjectMapper();

    @Benchmark
    public void serialize() throws Exception {
        objectMapper.readValue("{\"readPermissions\":[12341,52432],\"writePermissions\":[12734,52643],\"componentsPermission\":{\"btn_submit1\":[6231,93245],\"btn_submit2\":[6232,93245],\"btn_submit5\":[6236,93245],\"btn_submit3\":[6233,93245],\"btn_submit4\":[6234,93245]}}",MapSize.PageConfig.class);
    }
}
