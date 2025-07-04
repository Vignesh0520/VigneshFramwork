package pages.amazon;

import java.io.IOException;

import base.BaseClass;

public class DDF_WriteExcel extends BaseClass {

	public static void main(String[] args) throws IOException {

		// 1. "toys" -> Product to search on Amazon
		// 2. "ProductAndPrice" -> Sheet name inside the Excel file
		// 3. "AmazonSearchResults" -> Excel file name (without extension, e.g.,
		// AmazonSearchResults.xlsx)

		DDF_storeAmazonResultInExcel("toys", "ProductAndPrice", "AmazonSearchResults");

	}

}
