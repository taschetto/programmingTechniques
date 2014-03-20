public interface IAccount {
	public enum AccountStatus
	{
		New,
		Normal,
		Premium
	}
	
	//@ pure;
	AccountStatus GetAccountStatus();
	
	//@ requires GetAccountStatus() == AccountStatus.New;
	//@ ensures GetAccountStatus() == AccountStatus.Normal;
	void ApproveAccount();
	
	//@ requires GetAccountStatus() == AccountStatus.Normal;
	//@ ensures GetAccountStatus() == AccountStatus.Premium;
	void SetPremiumAccount();	
	
	//@ requires GetAccountStatus() != AccountStatus.New;
	//@ requires GetBalance() >= amount;
	//@ ensures GetBalance() == \old(GetBalance()) - amount;
	void Withdrawal(float amount);
	
	//@ requires GetAccountStatus() != AccountStatus.New;
	//@ ensures GetBalance() == \old(GetBalance()) + amount;
	void Deposit(float amount);
	
	//@ requires GetAccountStatus() == AccountStatus.Premium;
	//@ requires installments > 0 && installments <= 24;
	//@ requires HasLoan() == false;
	//@ ensures HasLoan() == true;
	void Loan(float amount, int installments);	
	
	//@ requires GetAccountStatus() != AccountStatus.New;
	//@ pure;
	float GetBalance();
	
	//@ pure;
	boolean HasLoan();
}
