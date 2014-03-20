package ex02;

public class Account implements IAccount {
	
	private float balance = 0;
	private AccountStatus accountStatus = AccountStatus.New;
	private float loan = 0;
	
	@SuppressWarnings("unused")
	private int installments = 0;

	@Override
	public AccountStatus GetAccountStatus() {
		return this.accountStatus;
	}

	@Override
	public void ApproveAccount() {
		this.accountStatus = AccountStatus.Normal;

	}

	@Override
	public void SetPremiumAccount() {
		this.accountStatus = AccountStatus.Premium;
	}

	@Override
	public void Withdrawal(float amount) {
		this.balance -= amount; 
	}

	@Override
	public void Deposit(float amount) {
		this.balance += amount;
	}

	@Override
	public void Loan(float amount, int installments) {
		this.loan = amount;
		this.installments = installments;
	}

	@Override
	public float GetBalance() {
		return this.balance;
	}

	@Override
	public boolean HasLoan() {
		return this.loan > 0;
	}

}
