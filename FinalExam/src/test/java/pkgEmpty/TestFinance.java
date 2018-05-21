package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

import org.apache.poi.ss.formula.functions.*;

public class TestFinance {

	@Test
	public void TestPV() {

		int iYearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;

		double PV = Retirement.PV(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
		
		

		assertEquals(1454485.55,Math.abs(PV),0.01);
		
		int iYearsToWorkB = 38;
		double dAnnualReturnWorkingB = 0.07;
		int iYearsRetiredB = 10;
		double dAnnualReturnRetiredB = 0.02;
		double dRequiredIncomeB = 12500;
		double dMonthlySSIB = 9256;
		
		double PVB = Retirement.PV(dAnnualReturnRetiredB / 12, iYearsRetiredB * 12, dRequiredIncomeB - dMonthlySSIB, 0, false);
		
		assertEquals(352557.14, Math.abs(PVB), 0.01);
		
	}

	@Test
	public void TestPMT() {

		int iYearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		
		double PV = Retirement.PV(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
		double PMT = Retirement.PMT(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, PV, false);
		
		assertEquals(554.13, Math.abs(PMT), 0.01);
		
		int iYearsToWorkB = 38;
		double dAnnualReturnWorkingB = 0.07;
		int iYearsRetiredB = 10;
		double dAnnualReturnRetiredB = 0.02;
		double dRequiredIncomeB = 12500;
		double dMonthlySSIB = 9256;
		
		double PVB = Retirement.PV(dAnnualReturnRetiredB / 12, iYearsRetiredB * 12, dRequiredIncomeB - dMonthlySSIB, 0, false);
		double PMTB = Retirement.PMT(dAnnualReturnWorkingB / 12, iYearsToWorkB * 12, 0, PVB, false);
		
		assertEquals(155.96, Math.abs(PMTB), 0.01);
	}
}
