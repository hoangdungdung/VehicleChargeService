package com.google.firebase.example;

import java.awt.Frame;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.google.cloud.Date;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServiceVehicleCharge {
	private static final String TABLE_CHARGE = "Charge";
	private static final String TABLE_CHARGE_KEY = "Charge_Key";
	private static final String TABLE_REQUEST_CHARGE = "RequestCharge";
	private static final String TABLE_RESPONSE_CHARGE = "ResponseCharge";
	private static final String TABLE_TIME_ZONE = "TimeZone";
	
	public static class TimeZone{
		public String Description;
		
		public String EndTime;
		
		public String StartTime;

		public TimeZone() {
		}

		public TimeZone(String description, String endTime, String startTime) {
			Description = description;
			EndTime = endTime;
			StartTime = startTime;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getEndTime() {
			return EndTime;
		}

		public void setEndTime(String endTime) {
			EndTime = endTime;
		}

		public String getStartTime() {
			return StartTime;
		}

		public void setStartTime(String startTime) {
			StartTime = startTime;
		}		
	}
	
	public static class Charge{
		public String chargeId;
		public String compannyId;
		public String compannyName;
		public float fee;
		public String inputer;
		public String timeZoneId;
		public String vehicleLocationId;
		public String vehicleLocationName;
		public String vehicleTypeId;
		public String vehicleTypeName;
		public String getCompannyId() {
			return compannyId;
		}
		public void setCompannyId(String compannyId) {
			this.compannyId = compannyId;
		}
		public String getCompannyName() {
			return compannyName;
		}
		public void setCompannyName(String compannyName) {
			this.compannyName = compannyName;
		}
		public float getFee() {
			return fee;
		}
		public void setFee(float fee) {
			this.fee = fee;
		}
		public String getInputer() {
			return inputer;
		}
		public void setInputer(String inputer) {
			this.inputer = inputer;
		}
		public String getTimeZoneId() {
			return timeZoneId;
		}
		public void setTimeZoneId(String timeZoneId) {
			this.timeZoneId = timeZoneId;
		}
		public String getVehicleLocationId() {
			return vehicleLocationId;
		}
		public void setVehicleLocationId(String vehicleLocationId) {
			this.vehicleLocationId = vehicleLocationId;
		}
		public String getVehicleLocationName() {
			return vehicleLocationName;
		}
		public void setVehicleLocationName(String vehicleLocationName) {
			this.vehicleLocationName = vehicleLocationName;
		}
		public String getVehicleTypeId() {
			return vehicleTypeId;
		}
		public void setVehicleTypeId(String vehicleTypeId) {
			this.vehicleTypeId = vehicleTypeId;
		}
		public String getVehicleTypeName() {
			return vehicleTypeName;
		}
		public void setVehicleTypeName(String vehicleTypeName) {
			this.vehicleTypeName = vehicleTypeName;
		}		
		
		public String getChargeId() {
			return chargeId;
		}
		public void setChargeId(String chargeId) {
			this.chargeId = chargeId;
		}
		public Charge(String compannyId, String compannyName, float fee, String inputer, String timeZoneId,
				String vehicleLocationId, String vehicleLocationName, String vehicleTypeId, String vehicleTypeName) {
			this.compannyId = compannyId;
			this.compannyName = compannyName;
			this.fee = fee;
			this.inputer = inputer;
			this.timeZoneId = timeZoneId;
			this.vehicleLocationId = vehicleLocationId;
			this.vehicleLocationName = vehicleLocationName;
			this.vehicleTypeId = vehicleTypeId;
			this.vehicleTypeName = vehicleTypeName;
		}
		public Charge() {
		}
	}
	
	public static class ChargeKey{
		public String chargeId;
		public float fee;
		
		public ChargeKey() {
		}

		public String getChargeId() {
			return chargeId;
		}

		public void setChargeId(String chargeId) {
			this.chargeId = chargeId;
		}

		public float getFee() {
			return fee;
		}

		public void setFee(float fee) {
			this.fee = fee;
		}
	}

	public static class RequestCharge{
		public String callerId;
		public String callerName;
		public String driverId;
	    public String driverName;
	    public String companyId;
	    public String companyName;
	    public String vehicleType;
	    public String vehicleTypeName;
	    public String time;
	    public String locationId;
	    public String locationName;
	    public String levelChargeId;
	    public float levelChargeValue;
	    public String campaignId;
	    public String campaignName;
	    public Integer pathLength;
	    public String sharegroupId;
	    public float shareGroupValue;
	    public float discount;

	    public RequestCharge() {
	    }

	    public String getCallerId() {
	        return callerId;
	    }

	    public void setCallerId(String callerId) {
	        this.callerId = callerId;
	    }

	    public String getCallerName() {
	        return callerName;
	    }

	    public void setCallerName(String callerName) {
	        this.callerName = callerName;
	    }

	    public String getDriverId() {
	        return driverId;
	    }

	    public void setDriverId(String driverId) {
	        this.driverId = driverId;
	    }

	    public String getDriverName() {
	        return driverName;
	    }

	    public void setDriverName(String driverName) {
	        this.driverName = driverName;
	    }

	    public String getCompanyId() {
	        return companyId;
	    }

	    public void setCompanyId(String companyId) {
	        this.companyId = companyId;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public String getVehicleType() {
	        return vehicleType;
	    }

	    public void setVehicleType(String vehicleType) {
	        this.vehicleType = vehicleType;
	    }

	    public String getTime() {
	        return time;
	    }

	    public void setTime(String time) {
	        this.time = time;
	    }

	    public String getLocationId() {
	        return locationId;
	    }

	    public void setLocationId(String locationId) {
	        this.locationId = locationId;
	    }

	    public String getLocationName() {
	        return locationName;
	    }

	    public void setLocationName(String locationName) {
	        this.locationName = locationName;
	    }

	    public String getLevelChargeId() {
	        return levelChargeId;
	    }

	    public void setLevelChargeId(String levelChargeId) {
	        this.levelChargeId = levelChargeId;
	    }

	    public String getCampaignId() {
	        return campaignId;
	    }

	    public void setCampaignId(String campaignId) {
	        this.campaignId = campaignId;
	    }

	    public String getCampaignName() {
	        return campaignName;
	    }

	    public void setCampaignName(String campaignName) {
	        this.campaignName = campaignName;
	    }

	    public Integer getPathLength() {
	        return pathLength;
	    }

	    public void setPathLength(Integer pathLength) {
	        this.pathLength = pathLength;
	    }

	    public String getSharegroupId() {
	        return sharegroupId;
	    }

	    public void setSharegroupId(String sharegroupId) {
	        this.sharegroupId = sharegroupId;
	    }

	    public String getVehicleTypeName() {
	        return vehicleTypeName;
	    }

	    public void setVehicleTypeName(String vehicleTypeName) {
	        this.vehicleTypeName = vehicleTypeName;
	    }

	    public float getLevelChargeValue() {
			return levelChargeValue;
		}

		public void setLevelChargeValue(float levelChargeValue) {
			this.levelChargeValue = levelChargeValue;
		}

		public float getShareGroupValue() {
	        return shareGroupValue;
	    }

	    public void setShareGroupValue(float shareGroupValue) {
	        this.shareGroupValue = shareGroupValue;
	    }

		public float getDiscount() {
			return discount;
		}

		public void setDiscount(float discount) {
			this.discount = discount;
		}
	}
	
	public static class ResponseChargeDriver{
		public String driverId;
		public float result;
		public String datetime;
		
		public ResponseChargeDriver() {
		}
		public String getDriverId() {
			return driverId;
		}
		public void setDriverId(String driverId) {
			this.driverId = driverId;
		}
		public float getResult() {
			return result;
		}
		public void setResult(float result) {
			this.result = result;
		}
		public String getDatetime() {
			return datetime;
		}
		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}
	}
	
	public static class ResponseChargeCaller{
		public String callerId;
		public float result;
		public String datetime;
		
		public ResponseChargeCaller() {
		}
		public String getCallerId() {
			return callerId;
		}
		public void setCallerId(String callerId) {
			this.callerId = callerId;
		}
		public float getResult() {
			return result;
		}
		public void setResult(float result) {
			this.result = result;
		}
		public String getDatetime() {
			return datetime;
		}
		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}
	}
	
	public void ServiceCalculate() {
		System.out.println("Start Service VEHICLE_CHARGE successfully");
			
		FirebaseDatabase database = FirebaseDatabase.getInstance();
    	
    	DatabaseReference tableCharge = database.getReference(TABLE_CHARGE);
    	DatabaseReference tableChargeKey = database.getReference(TABLE_CHARGE_KEY);
    	DatabaseReference tableRequestCharge = database.getReference(TABLE_REQUEST_CHARGE);
    	DatabaseReference tableResponseCharge = database.getReference(TABLE_RESPONSE_CHARGE);
    	DatabaseReference tableTimeZone = database.getReference(TABLE_TIME_ZONE);
    	
    	tableCharge.addChildEventListener(new ChildEventListener() {
			
			@Override
			public void onChildRemoved(DataSnapshot snapshot) {	
			}
			
			@Override
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
			}
			
			@Override
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {			
			}
			
			@Override
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				if(snapshot.exists()) {
					try {
						Charge charge = snapshot.getValue(Charge.class);
						if(charge != null) {
							StringBuilder keyTbChargeKey = new StringBuilder();
							keyTbChargeKey.append(charge.getCompannyId());
							keyTbChargeKey.append("/");
							keyTbChargeKey.append(charge.getVehicleTypeId());
							keyTbChargeKey.append("/");
							keyTbChargeKey.append(charge.getVehicleLocationId());
							keyTbChargeKey.append("/");
							keyTbChargeKey.append(charge.getTimeZoneId());
							keyTbChargeKey.append("/");
							
							ChargeKey chargkey = new ChargeKey();
							chargkey.setChargeId(snapshot.getKey());
							chargkey.setFee(charge.getFee());
							
							tableChargeKey.child(keyTbChargeKey.toString()).setValue(chargkey);
							
							System.out.println("Add CHARGE_KEY successfully");
						}
					}catch (Exception e) {
						System.out.println("Error: "+ e.toString());
					}										
				}			
			}
			
			@Override
			public void onCancelled(DatabaseError error) {			
			}
		});
	
    	tableRequestCharge.addChildEventListener(new ChildEventListener() {
			
			@Override
			public void onChildRemoved(DataSnapshot snapshot) {				
			}
			
			@Override
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {			
			}
			
			@Override
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {					
			}
			
			@Override
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				if(snapshot.exists()) {
					try {
						String requestChargeId = snapshot.getKey();
						
						RequestCharge requestCharge = snapshot.getValue(RequestCharge.class);
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
						Calendar date = Calendar.getInstance();
						date.setTime(formatter.parse(requestCharge.getTime()));					
						String houre = String.valueOf(date.HOUR_OF_DAY);
												
						tableTimeZone.addValueEventListener(new ValueEventListener() {
							
							@Override
							public void onDataChange(DataSnapshot snapshot) {
								String seletedTimeZoneId = "24";
								if(snapshot.exists()) {
									for(DataSnapshot item : snapshot.getChildren()) {
										if(item.getKey().equals(houre)) {
											seletedTimeZoneId = item.getKey();
											break;
										}
									}	
									
								tableChargeKey.child(requestCharge.getCompanyId())
												.child(requestCharge.getVehicleType())
												.child(requestCharge.getLocationId())
												.child(seletedTimeZoneId)
												.addListenerForSingleValueEvent(new ValueEventListener() {													
													@Override
													public void onDataChange(DataSnapshot snapshot) {
														ChargeKey chargeKey = snapshot.getValue(ChargeKey.class);
														if(chargeKey != null) {
															
															System.out.println("Fee: "+ chargeKey.fee);
															System.out.println("Share Group: "+ requestCharge.getShareGroupValue());
															System.out.println("Level charge: "+ requestCharge.getLevelChargeValue());
															System.out.println("Discount: "+ requestCharge.getDiscount());
															
															
															float result = chargeKey.fee * 		
																		(requestCharge.getShareGroupValue()/100) * 
																		(requestCharge.getLevelChargeValue()/100) *
																		(requestCharge.getDiscount()/100) * 
																		1000;
															
															ResponseChargeCaller responseCaller = new ResponseChargeCaller();
															responseCaller.setCallerId(requestCharge.callerId);
															responseCaller.setResult(result);
															responseCaller.setDatetime(requestCharge.time);
															
															tableResponseCharge.child(requestCharge.driverId)
																				.child("caller")
																				.child(requestChargeId)
																				.setValue(responseCaller);
															
															ResponseChargeDriver responseDriver = new ResponseChargeDriver();
															responseDriver.setDriverId(requestCharge.driverId);
															responseDriver.setResult(result);
															responseDriver.setDatetime(requestCharge.time);
																														
															tableResponseCharge.child(requestCharge.callerId)
																				.child("driver")
																				.child(requestChargeId)
																				.setValue(responseDriver);
														}					
													}
													
													@Override
													public void onCancelled(DatabaseError error) {													
													}
												});									
								}
								tableTimeZone.removeEventListener(this);
								
							}
							
							@Override
							public void onCancelled(DatabaseError error) {							
							}
						});												
					}
					catch (Exception e) {
						System.out.println("Error: "+ e.toString());
					}		
				}				
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
			}
		});
	}
	
}
