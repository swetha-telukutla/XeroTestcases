package xero.main.module;

import java.io.IOException;

import xero.testcases.AccountsModule;
import xero.testcases.AllTabsModule;
import xero.testcases.FreeTrailModule;
import xero.testcases.LogOutTC;
import xero.testcases.LoginModule;
import xero.testcases.NewOrganizationModule;
import xero.testcases.T1;
import xero.testcases.UploadImgModule;

/**
 * 
 * @author Swetha Main Entry for test cases.
 */
public class DriversEngine {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		LoginModule.t1();
		LoginModule.t2();
		LoginModule.t3();
		//LoginModule.t4();
		FreeTrailModule.t5();
		FreeTrailModule.t6();
		FreeTrailModule.t7();
		FreeTrailModule.t8();
		FreeTrailModule.t9();
		AllTabsModule.t10();
		LogOutTC.logOutTestCase();
		UploadImgModule.t12();
		//NewOrganizationModule.t13();
		//NewOrganizationModule.t14();
		NewOrganizationModule.t15();
		AccountsModule.t16();

	}
}