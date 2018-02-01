package kr.co.koscom.marketdata.calc;

import kr.co.koscom.marketdata.model.InputModel;
import kr.co.koscom.marketdata.model.Master;
import kr.co.koscom.marketdata.model.Price;
import kr.co.koscom.marketdata.model.Trend;

public class Calculator {
	
	//private int resultvalue;
	
	private int namecalvalue;
	//private int birthcalvalue;
	
	
	public double sigmoid(double x) {
		return (1 / (1 + Math.pow(Math.E, (-1 * x))));
	}
	
	
	public int nameCal(String name, String companyname)
	{
		namecalvalue=0;
		AlphabetSplit alp = new AlphabetSplit();
		int[] namevaluelist= alp.nameSplit(name);
		int[] companyvaluelist = alp.nameSplit(companyname);
		
		//점수합산부분 구현
		
		int[] temparray = new int[6];
		int[] calarray = new int[6];
		
		temparray[0]=namevaluelist[0];
		temparray[1]=companyvaluelist[0];
		temparray[2]=namevaluelist[1];
		temparray[3]=companyvaluelist[1];
		temparray[4]=namevaluelist[2];
		temparray[5]=companyvaluelist[2];
		
		for(int i=0;i<5;i++){
			calarray[i]= (temparray[i]+temparray[i+1] ) % 10 ;
		}
		for(int i=0;i<4;i++){
			temparray[i]= (calarray[i]+calarray[i+1] ) % 10 ;
		}
		for(int i=0;i<3;i++){
			calarray[i]= (temparray[i]+temparray[i+1] ) % 10 ;
		}
		for(int i=0;i<2;i++){
			temparray[i]= (calarray[i]+calarray[i+1] )  % 10;
		}
		//System.out.println("value value 10의자리: "+temparray[0]+"value value 1의자리: "+temparray[1]);
		namecalvalue = (temparray[0] * 10) + temparray[1];
		
		return namecalvalue;
	}
	
	/* input: parval, hgprc, lwprc
	 * output: score ( 0 <= score <= 1 )
	 */
	public double score1(int parval /* 액면가 */,
			int hgprc /* 고가 */,
			int lwprc /* 저가 */) {
		if (parval == 0) return 0;
		/* 대략적인 '액면가' 대비 '고가와 저가의 차이' 비율 */
		double score = ((hgprc-lwprc) % parval) / (parval * 1.0);
		return score;
	}
	
	/* input: prevddclsprc, opnprc
	 * output: score ( -1 <= score <= 1 ) 
	 */
	public double score2(int prevddclsprc /* 전일종가 */,
			int opnprc /* 시가 */) {
		if (prevddclsprc == 0) return 0;
		/* 전일종가 대비 시가의 변화 비율 */
		double score = (prevddclsprc - opnprc) / (prevddclsprc * 1.0);
		if (score < -1.0) score = -1.0;
		return score;
	}
	
	/* input: value, count
	 * output: bonus_score ( 0 <= bonus_score <= 1 )
	 */
	public double bonus_score1(double trend_value /* 트랜드 값 */,
			int trend_count /* 트랜드 수 */) {
		if (trend_value == 0) return 0;
		/* no reason ... */
		double tv = trend_value;
		while (tv < trend_count) tv *= 10;
		return trend_count / ((int)(tv) * 1.0);
	}

	/* input: scores, bonus_scores
	 * output: friendly_score ( 0 <= friendly_score <= 1 )
	 */
	public double friendly_score1(double[] scores /* 종합 치수 */,
			double[] bonus_scores /* 추가 치수  */) {
		/* calc. sums */
		double sum_scores = 0.0;
		double sum_bonus_scores = 0.0;
		for (double score : scores) {
			sum_scores += score;
		}
		for (double bonus_score : bonus_scores) {
			sum_bonus_scores += bonus_score;
		}
		/* calc. avgs */
		double avg_score = sum_scores / scores.length;
		double avg_bonus_score = sum_bonus_scores / bonus_scores.length;
		/* calc. friendly score 
		 * no reason ...
		 * scores로는 -0.5 ~ +0.5 사이의 값을 도출하며, bonus_scores로는 추가점수 0 ~ +0.5 사이의 값을 도출하여 합함
		 */
		double w1 = 5;
		double w2 = 5;
		System.out.println("avg_score: " + avg_score);
		System.out.println("avg_bonus_score: " + avg_bonus_score);
		System.out.println("sigmoid(avg_score*w1): " + sigmoid(avg_score*w1));
		System.out.println("sigmoid(avg_bonus_score*w2): " + sigmoid(avg_bonus_score*w2));
		
		double fs = (sigmoid(avg_score*w1) - 0.5) + (sigmoid(avg_bonus_score*w2) / 2);
		return fs;
	}
	
	public String cutName(String name) {
		if(name.length() > 3)
			return name.substring(0, 2);
		else if(name.length() <3)
			return name + "럘";
		else
			return name;
	}
	
	public double calcAll(InputModel inputmodel, Price price, Master master, Trend trend, double[] scores, double[] bonus_scores){
		scores[0] = (nameCal(cutName(inputmodel.getName()), cutName(master.getIsuKorAbbrv())) / 100.0); /* 0 <= nameCalval <= 1 */
		scores[1] = score1(Integer.parseInt(master.getParval()), (int)price.getHgprc(), (int)price.getLwprc());
		scores[2] = score2(Integer.parseInt(master.getPrevddClsprc()), (int)price.getOpnprc());
		bonus_scores[0] = bonus_score1(Double.parseDouble(trend.getValue()), Integer.parseInt(trend.getCount()));

		double friendly_score = (int)(friendly_score1(scores,  bonus_scores) * 1000) / 10.0;
		
		return friendly_score;
	}
	
	
}
