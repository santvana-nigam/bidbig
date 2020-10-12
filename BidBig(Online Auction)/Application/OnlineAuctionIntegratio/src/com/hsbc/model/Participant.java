package com.hsbc.model;

public class Participant {

	private long participantId;
	private double bidValue;
	private long buyerId;
	private long bidId;
	private ParticipationStatusType participationStatusType;
	
	public Participant() {
		// TODO Auto-generated constructor stub
	}

	public Participant(long participantId, double bidValue, long buyerId, long bidId,
			ParticipationStatusType participationStatusType) {
		super();
		this.participantId = participantId;
		this.bidValue = bidValue;
		this.buyerId = buyerId;
		this.bidId = bidId;
		this.participationStatusType = participationStatusType;
	}


	public long getParticipantId() {
		return participantId;
	}


	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}


	public double getBidValue() {
		return bidValue;
	}


	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
	}


	public long getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}


	public long getBidId() {
		return bidId;
	}


	public void setBidId(long bidId) {
		this.bidId = bidId;
	}


	public ParticipationStatusType getParticipationStatusType() {
		return participationStatusType;
	}


	public void setParticipationStatusType(ParticipationStatusType participationStatusType) {
		this.participationStatusType = participationStatusType;
	}


	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", bidValue=" + bidValue + ", buyerId=" + buyerId
				+ ", bidId=" + bidId + ", participationStatus=" + participationStatusType + "]";
	}

}
