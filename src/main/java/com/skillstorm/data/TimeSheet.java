package com.skillstorm.data;

public class TimeSheet 
{
	private int TimeSheetId;
    private String mondaysHours;
    private String tuesdaysHours;
    private String wednesdaysHours;
    private String thursdaysHours;
    private String fridaysHours;
    private String saturdaysHours;
    private String sundaysHours;
    private String dateEndingIn;
    private String userId;
    private boolean timeSheetSubitted;
    
    TimeSheet(){}

	public int getTimeSheetId() {
		return TimeSheetId;
	}

	public void setTimeSheetId(int timeSheetId) {
		TimeSheetId = timeSheetId;
	}

	public String getMondaysHours() {
		return mondaysHours;
	}

	public void setMondaysHours(String mondaysHours) {
		this.mondaysHours = mondaysHours;
	}

	public String getTuesdaysHours() {
		return tuesdaysHours;
	}

	public void setTuesdaysHours(String tuesdaysHours) {
		this.tuesdaysHours = tuesdaysHours;
	}

	public String getWednesdaysHours() {
		return wednesdaysHours;
	}

	public void setWednesdaysHours(String wednesdaysHours) {
		this.wednesdaysHours = wednesdaysHours;
	}

	public String getThursdaysHours() {
		return thursdaysHours;
	}

	public void setThursdaysHours(String thursdaysHours) {
		this.thursdaysHours = thursdaysHours;
	}

	public String getFridaysHours() {
		return fridaysHours;
	}

	public void setFridaysHours(String fridaysHours) {
		this.fridaysHours = fridaysHours;
	}

	public String getSaturdaysHours() {
		return saturdaysHours;
	}

	public void setSaturdaysHours(String saturdaysHours) {
		this.saturdaysHours = saturdaysHours;
	}

	public String getSundaysHours() {
		return sundaysHours;
	}

	public void setSundaysHours(String sundaysHours) {
		this.sundaysHours = sundaysHours;
	}

	public String getDateEndingIn() {
		return dateEndingIn;
	}

	public void setDateEndingIn(String dateEndingIn) {
		this.dateEndingIn = dateEndingIn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isTimeSheetSubitted() {
		return timeSheetSubitted;
	}

	public void setTimeSheetSubitted(boolean timeSheetSubitted) {
		this.timeSheetSubitted = timeSheetSubitted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TimeSheetId;
		result = prime * result + ((dateEndingIn == null) ? 0 : dateEndingIn.hashCode());
		result = prime * result + ((fridaysHours == null) ? 0 : fridaysHours.hashCode());
		result = prime * result + ((mondaysHours == null) ? 0 : mondaysHours.hashCode());
		result = prime * result + ((saturdaysHours == null) ? 0 : saturdaysHours.hashCode());
		result = prime * result + ((sundaysHours == null) ? 0 : sundaysHours.hashCode());
		result = prime * result + ((thursdaysHours == null) ? 0 : thursdaysHours.hashCode());
		result = prime * result + (timeSheetSubitted ? 1231 : 1237);
		result = prime * result + ((tuesdaysHours == null) ? 0 : tuesdaysHours.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((wednesdaysHours == null) ? 0 : wednesdaysHours.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSheet other = (TimeSheet) obj;
		if (TimeSheetId != other.TimeSheetId)
			return false;
		if (dateEndingIn == null) {
			if (other.dateEndingIn != null)
				return false;
		} else if (!dateEndingIn.equals(other.dateEndingIn))
			return false;
		if (fridaysHours == null) {
			if (other.fridaysHours != null)
				return false;
		} else if (!fridaysHours.equals(other.fridaysHours))
			return false;
		if (mondaysHours == null) {
			if (other.mondaysHours != null)
				return false;
		} else if (!mondaysHours.equals(other.mondaysHours))
			return false;
		if (saturdaysHours == null) {
			if (other.saturdaysHours != null)
				return false;
		} else if (!saturdaysHours.equals(other.saturdaysHours))
			return false;
		if (sundaysHours == null) {
			if (other.sundaysHours != null)
				return false;
		} else if (!sundaysHours.equals(other.sundaysHours))
			return false;
		if (thursdaysHours == null) {
			if (other.thursdaysHours != null)
				return false;
		} else if (!thursdaysHours.equals(other.thursdaysHours))
			return false;
		if (timeSheetSubitted != other.timeSheetSubitted)
			return false;
		if (tuesdaysHours == null) {
			if (other.tuesdaysHours != null)
				return false;
		} else if (!tuesdaysHours.equals(other.tuesdaysHours))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (wednesdaysHours == null) {
			if (other.wednesdaysHours != null)
				return false;
		} else if (!wednesdaysHours.equals(other.wednesdaysHours))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeSheet [TimeSheetId=" + TimeSheetId + ", mondaysHours=" + mondaysHours + ", tuesdaysHours="
				+ tuesdaysHours + ", wednesdaysHours=" + wednesdaysHours + ", thursdaysHours=" + thursdaysHours
				+ ", fridaysHours=" + fridaysHours + ", saturdaysHours=" + saturdaysHours + ", sundaysHours="
				+ sundaysHours + ", dateEndingIn=" + dateEndingIn + ", userId=" + userId + ", timeSheetSubitted="
				+ timeSheetSubitted + "]";
	};
    
    
}
