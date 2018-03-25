package Model;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    /**
     * 测试工程
     */
    public String testEngineering;
    /**
     * 需求编号
     */
    public String reqId;
    /**
     * 案例编号
     */
    public String testCaseId;
    /**
     * 需求参考
     */
    public String reqReference;
    /**
     * 特殊条件
     */
    public String specialCondition;
    /**
     * 测试目的/场景
     */
    public String testGoal;
    /**
     * 测试步骤
     */
    public String stepDes;
    /**
     * 案例
     */
    public String caseDes;
    /**
     * 检查点
     */
    public String checkPoint;
    /**
     * 优先级
     */
    public String Priority;
    /**
     * 案例性质
     */
    public String caseNature;
    /**
     * 案例状态
     */
    public String caseState;
    /**
     * 作者
     */
    public String aurthor;
    /**
     * 备注
     */
    public String remark;
    /**
     * QC案例编号
     */
    public String QCId;

    public String toString() {
        return "[" + testEngineering + "," + reqId + "," + testCaseId + "," + reqReference + "," + specialCondition + "," + testGoal + "," + stepDes + "," + caseDes + "," + checkPoint + "," + Priority + "," + caseNature + "," + caseState + "," + aurthor + "," + remark + "," + QCId + "]";
    }

    public TestCase(){

    }
    public TestCase(List<String> strArr){
        testEngineering=strArr.get(0);
        reqId=strArr.get(1);
        testCaseId=strArr.get(2);
        reqReference=strArr.get(3);
        specialCondition=strArr.get(4);
        testGoal=strArr.get(5);
        stepDes=strArr.get(6);
        caseDes=strArr.get(7);
        checkPoint=strArr.get(8);
        Priority=strArr.get(9);
        caseNature=strArr.get(10);
        caseState=strArr.get(11);
        aurthor=strArr.get(12);
        remark=strArr.get(13);
        QCId=strArr.get(14);
    }

    public List<String> testCase2StrArr() {
        List<String> ret = new ArrayList<>();
        ret.add(testEngineering);
        ret.add(reqId);
        ret.add(testCaseId);
        ret.add(reqReference);
        ret.add(specialCondition);
        ret.add(testGoal);
        ret.add(stepDes);
        ret.add(caseDes);
        ret.add(checkPoint);
        ret.add(Priority);
        ret.add(caseNature);
        ret.add(caseState);
        ret.add(aurthor);
        ret.add(remark);
        ret.add(QCId);
        return ret;
    }
}

