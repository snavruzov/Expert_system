package edu.expert.ai.pulman.dao;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface ContentDAO {

    public LinkedHashMap<Integer,Map<Integer,Integer>> getPulmanMarks(Integer patientCount);
    public LinkedHashMap<Integer,Integer> getNominalGradationByCount();
    public Long getPulmanPatientTableCount();
    public Long getPulmanNeNullGradationValues(Integer alias, Integer clazz);
    public Long getPulmanGradationValuesByField(Integer alias, Integer symp,Integer clazz);
    public Long getPulmanXorGradationValuesByField(Integer alias, Integer symp,Integer clazz);
    public Long getPulmanNullGradationValuesByField(Integer alias, Integer clazz);
    public Long getPulmanNominalTableCount(Integer alias);
    public Long getPulmanClazzTableCount(Integer clazz);
    public Long getPulmanNeNullCLGradationValues(Integer alias, Integer clazz);
    public LinkedHashMap<Integer,Integer> getCountableGradationByCount();

}
