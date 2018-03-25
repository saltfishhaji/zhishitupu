package Tools;

import Model.Pair;
import Model.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class RelationExtraction {
    // "[.,!?\\s]+"
    //splitWords1[] = {"：为", "=为", "=", "为：",">", "<", "大于", "小于","为",":","：", "等于"};
    public static List<Pair> divideOnly(List<TestCase> testCases, String regularS, String relationSplits[]) {
        List<Pair> ret = new ArrayList<>();
        for (TestCase testCase : testCases) {
            List<String> strarr = testCase.testCase2StrArr();
            for (String eachitem : strarr) {
                String[] eachStrs = eachitem.split(regularS);
                for (String eachStr : eachStrs) {
                    for (String split : relationSplits) {
                        if (eachStr.contains(split) && eachStr.split(split).length == 2) {
                            ret.add(new Pair(eachStr.split(split)[0],eachStr.split(split)[1]));
                        }
                    }
                }
            }
        }
        return ret;
    }
}
