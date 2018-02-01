package kr.co.koscom.marketdata.model;

import java.io.Serializable;

public class Master implements Serializable{
	
	private static final long serialVersionUID = 5328249083677015804L;

	private String isuSrtCd ;
	private String prevddClsprc ;  
	private String prevddAccTrdvol ;  
	private String prevddAccTrdval ;
	private String prevddNav ;
	private String trdDd ; 
	private String acntclsMm ; 
	private String acntclsCd ; 
	private String eps ; 
	private String bps ;
	private String per ; 
	private String pbr ;
	private String divYd ; 
	private String basPrc ; 
	private String arrantrdYn ; 
	private String isuKorAbbrv ; 
	private String isuCd ; 
	private String listDd ;
	private String idxIndUpclssCd ; 
	private String idxIndMidclssCd ;
	private String idxIndLwclssCd ; 
	private String mfindYn ; 
	private String kospi100Yn; 
	private String kospi50Yn; 
	private String parval; 
	private String dps; 
	private String admisuYn; 
	private String mktWarnTpCd; 
	private String haltYn; 
	private String isuPrc; 
	private String uplmtprc; 
	private String lwlmtprc ;
	private String sbPrc; 
	private String listShrs; 
	private String regulssQtyUnit; 
	
	public String getIsuSrtCd() {
		return isuSrtCd;
	}
	public void setIsuSrtCd(String isuSrtCd) {
		this.isuSrtCd = isuSrtCd;
	}
	public String getPrevddClsprc() {
		return prevddClsprc;
	}
	public void setPrevddClsprc(String prevddClsprc) {
		this.prevddClsprc = prevddClsprc;
	}
	public String getPrevddAccTrdvol() {
		return prevddAccTrdvol;
	}
	public void setPrevddAccTrdvol(String prevddAccTrdvol) {
		this.prevddAccTrdvol = prevddAccTrdvol;
	}
	public String getPrevddAccTrdval() {
		return prevddAccTrdval;
	}
	public void setPrevddAccTrdval(String prevddAccTrdval) {
		this.prevddAccTrdval = prevddAccTrdval;
	}
	public String getPrevddNav() {
		return prevddNav;
	}
	public void setPrevddNav(String prevddNav) {
		this.prevddNav = prevddNav;
	}
	public String getTrdDd() {
		return trdDd;
	}
	public void setTrdDd(String trdDd) {
		this.trdDd = trdDd;
	}
	public String getAcntclsMm() {
		return acntclsMm;
	}
	public void setAcntclsMm(String acntclsMm) {
		this.acntclsMm = acntclsMm;
	}
	public String getAcntclsCd() {
		return acntclsCd;
	}
	public void setAcntclsCd(String acntclsCd) {
		this.acntclsCd = acntclsCd;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getBps() {
		return bps;
	}
	public void setBps(String bps) {
		this.bps = bps;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getPbr() {
		return pbr;
	}
	public void setPbr(String pbr) {
		this.pbr = pbr;
	}
	public String getDivYd() {
		return divYd;
	}
	public void setDivYd(String divYd) {
		this.divYd = divYd;
	}
	public String getBasPrc() {
		return basPrc;
	}
	public void setBasPrc(String basPrc) {
		this.basPrc = basPrc;
	}
	public String getArrantrdYn() {
		return arrantrdYn;
	}
	public void setArrantrdYn(String arrantrdYn) {
		this.arrantrdYn = arrantrdYn;
	}
	public String getIsuKorAbbrv() {
		return isuKorAbbrv;
	}
	public void setIsuKorAbbrv(String isuKorAbbrv) {
		this.isuKorAbbrv = isuKorAbbrv;
	}
	public String getIsuCd() {
		return isuCd;
	}
	public void setIsuCd(String isuCd) {
		this.isuCd = isuCd;
	}
	public String getListDd() {
		return listDd;
	}
	public void setListDd(String listDd) {
		this.listDd = listDd;
	}
	public String getIdxIndUpclssCd() {
		return idxIndUpclssCd;
	}
	public void setIdxIndUpclssCd(String idxIndUpclssCd) {
		this.idxIndUpclssCd = idxIndUpclssCd;
	}
	public String getIdxIndMidclssCd() {
		return idxIndMidclssCd;
	}
	public void setIdxIndMidclssCd(String idxIndMidclssCd) {
		this.idxIndMidclssCd = idxIndMidclssCd;
	}
	public String getIdxIndLwclssCd() {
		return idxIndLwclssCd;
	}
	public void setIdxIndLwclssCd(String idxIndLwclssCd) {
		this.idxIndLwclssCd = idxIndLwclssCd;
	}
	public String getMfindYn() {
		return mfindYn;
	}
	public void setMfindYn(String mfindYn) {
		this.mfindYn = mfindYn;
	}
	public String getKospi100Yn() {
		return kospi100Yn;
	}
	public void setKospi100Yn(String kospi100Yn) {
		this.kospi100Yn = kospi100Yn;
	}
	public String getKospi50Yn() {
		return kospi50Yn;
	}
	public void setKospi50Yn(String kospi50Yn) {
		this.kospi50Yn = kospi50Yn;
	}
	public String getParval() {
		return parval;
	}
	public void setParval(String parval) {
		this.parval = parval;
	}
	public String getDps() {
		return dps;
	}
	public void setDps(String dps) {
		this.dps = dps;
	}
	public String getAdmisuYn() {
		return admisuYn;
	}
	public void setAdmisuYn(String admisuYn) {
		this.admisuYn = admisuYn;
	}
	public String getMktWarnTpCd() {
		return mktWarnTpCd;
	}
	public void setMktWarnTpCd(String mktWarnTpCd) {
		this.mktWarnTpCd = mktWarnTpCd;
	}
	public String getHaltYn() {
		return haltYn;
	}
	public void setHaltYn(String haltYn) {
		this.haltYn = haltYn;
	}
	public String getIsuPrc() {
		return isuPrc;
	}
	public void setIsuPrc(String isuPrc) {
		this.isuPrc = isuPrc;
	}
	public String getUplmtprc() {
		return uplmtprc;
	}
	public void setUplmtprc(String uplmtprc) {
		this.uplmtprc = uplmtprc;
	}
	public String getLwlmtprc() {
		return lwlmtprc;
	}
	public void setLwlmtprc(String lwlmtprc) {
		this.lwlmtprc = lwlmtprc;
	}
	public String getSbPrc() {
		return sbPrc;
	}
	public void setSbPrc(String sbPrc) {
		this.sbPrc = sbPrc;
	}
	public String getListShrs() {
		return listShrs;
	}
	public void setListShrs(String listShrs) {
		this.listShrs = listShrs;
	}
	public String getRegulssQtyUnit() {
		return regulssQtyUnit;
	}
	public void setRegulssQtyUnit(String regulssQtyUnit) {
		this.regulssQtyUnit = regulssQtyUnit;
	}
	public String getMktcapScaleCd() {
		return mktcapScaleCd;
	}
	public void setMktcapScaleCd(String mktcapScaleCd) {
		this.mktcapScaleCd = mktcapScaleCd;
	}
	public String getKospiYn() {
		return kospiYn;
	}
	public void setKospiYn(String kospiYn) {
		this.kospiYn = kospiYn;
	}
	public String getInvstcautnRemndIsuYn() {
		return invstcautnRemndIsuYn;
	}
	public void setInvstcautnRemndIsuYn(String invstcautnRemndIsuYn) {
		this.invstcautnRemndIsuYn = invstcautnRemndIsuYn;
	}
	public String getSrttrmOverheatIsuTpCd() {
		return srttrmOverheatIsuTpCd;
	}
	public void setSrttrmOverheatIsuTpCd(String srttrmOverheatIsuTpCd) {
		this.srttrmOverheatIsuTpCd = srttrmOverheatIsuTpCd;
	}
	public String getSecugrpId() {
		return secugrpId;
	}
	public void setSecugrpId(String secugrpId) {
		this.secugrpId = secugrpId;
	}
	public String getSmeYn() {
		return smeYn;
	}
	public void setSmeYn(String smeYn) {
		this.smeYn = smeYn;
	}
	public String getIsuTrdvol() {
		return isuTrdvol;
	}
	public void setIsuTrdvol(String isuTrdvol) {
		this.isuTrdvol = isuTrdvol;
	}
	public String getCreditOrdPosblYn() {
		return creditOrdPosblYn;
	}
	public void setCreditOrdPosblYn(String creditOrdPosblYn) {
		this.creditOrdPosblYn = creditOrdPosblYn;
	}
	public String getAdjStkprcCalcYn() {
		return adjStkprcCalcYn;
	}
	public void setAdjStkprcCalcYn(String adjStkprcCalcYn) {
		this.adjStkprcCalcYn = adjStkprcCalcYn;
	}
	private String mktcapScaleCd ;
	private String kospiYn; 
	private String invstcautnRemndIsuYn; 
	private String srttrmOverheatIsuTpCd ;
	private String secugrpId; 
	private String smeYn; 
	private String isuTrdvol; 
	private String creditOrdPosblYn; 
	private String adjStkprcCalcYn; 
}