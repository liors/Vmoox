package com.efectiveit.prototype.client.constans;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {
	String joinUrlParameter();
    String createdUrlParameter();
	String expirationMessageUrlParameter();
	String appRedirectUrl();
	String loggedOutParameter();
	String clientSessionTimeOut();
	int itemTakingTooLongNotificationThreshold();
    int itemPollingRequestLimit();
	String tokenUrlParameter();
	String usernameUrlParameter();
	String passwordResetSuccess();
	String passwordResetFailure();
	String loggedOutDueToAccountRemoveParameter();
    String confirmationEmailUrlParameter();
    String confirmationEmailTokenUrlParameter();
    int maxItemsPerUser();
    String recaptchaPublicKey();
    String loginErrorUrlHash();
    double paidPremiumPrice();
    double paidPremiumPlusPrice();
}
