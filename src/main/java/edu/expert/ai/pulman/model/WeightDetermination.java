package edu.expert.ai.pulman.model;

import edu.expert.ai.pulman.api.constants.AI;
import edu.expert.ai.pulman.beans.WeightMarks;
import edu.expert.ai.pulman.dao.ContentDAO;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 6/25/13
 * Time: 6:00 PM
 */
public class WeightDetermination
{
    private Double[][] weight;
    private Long pCnt;

    public WeightDetermination()
    {}

    public WeightDetermination(LinkedHashMap<Integer, Integer> grd,
                               LinkedHashMap<Integer, Integer> cGrd, ContentDAO dao)
    {
        this.pCnt= dao.getPulmanPatientTableCount();
        this.weight = new Double[pCnt.intValue()+1][grd.size()+cGrd.size()+2];
       // initInitialElems(dao);
        calculate(grd,dao);

    }

    private void initInitialElems(ContentDAO dao)
    {
        Long pCnt = dao.getPulmanPatientTableCount();
        for(int i=1;i<=pCnt;i++)
        {
            //this.weight.add(null);
        }
    }

    private void calculate(LinkedHashMap<Integer, Integer> grd, ContentDAO dao)
    {
        LinkedList<Integer> GT = new LinkedList<>();
        Integer ct = 0;
        Integer k2 = 0;
        //Double[] aSymptom = new Double[]{};
        //Определение весов для каждого объекта...


        LinkedHashMap<Integer,Integer> countableMarkCnt = dao.getCountableGradationByCount();
        System.out.println("VOUNTSABLE:----: "+countableMarkCnt);
        LinkedHashMap<Integer,Map<Integer,Integer>> xBase = dao.getPulmanMarks(pCnt.intValue());
        for (int d = 1; d <= AI.CLAZZ_CNT; d++)
        {
            Long clCnt = dao.getPulmanClazzTableCount(d);
            for (int r = 1; r <= clCnt; r++)
            {
                ++k2;
                //aSymptom = new Double[]{};
                for (Integer c : grd.keySet())
                {
                    Double value = InterClassDistinction.LAMBDA().get(c)
                            *InnerClassDistinction.BETA()[d][c];

                    //HashMap<Integer,Double> hMap = new HashMap<>();
                    //aSymptom[c] = value;
                    this.weight[k2][c] = (value);
                }
            }
        }

        int r0sum = 0;
        for (int r = 1; r <= pCnt; r++)
        {
            for(Map.Entry<Integer,Integer> i:countableMarkCnt.entrySet())
            {
                //WeightMarks tmp = this.weight.get(r);

                //aSymptom = new Double[]{};
                this.weight[r][i.getKey()] = i.getValue().doubleValue();
                r0sum+=(this.weight[r][i.getKey()]*this.weight[r][i.getKey()]);
            }

            this.weight[r][0] = -0.5*r0sum;
            r0sum = 0;
        }

    }

    public Double[][] getWeight()
    {
        return weight;
    }

    public void setWeight(Double[][] weight)
    {
        this.weight = weight;
    }
}
