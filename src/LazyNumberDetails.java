import java.util.Scanner;

public class LazyNumberDetails {

	private int number;
	private boolean cachedIsPrime;
	private boolean isPrimeCacheDirty;

	private boolean cachedIsPerfect;
	private boolean isPerfectCacheDirty;

	private boolean cachedIsMagic;
	private boolean isMagicCacheDirty;

	public LazyNumberDetails(int number) {
		this.number = number;

		this.cachedIsPrime = false;
		this.isPrimeCacheDirty = true;

		this.cachedIsPerfect = false;
		this.isPerfectCacheDirty = true;

		this.cachedIsMagic = false;
		this.isMagicCacheDirty = true;
	}

	public void updateNumber(int number) {
		if (number != this.number) {
			this.number = number;
			this.cachedIsPrime = false;
			this.isPrimeCacheDirty = true;
			this.cachedIsPerfect = false;
			this.isPerfectCacheDirty = true;
			this.cachedIsMagic = false;
			this.isMagicCacheDirty = true;
		}
	}

	public boolean isPrime() {
		if (!this.isPrimeCacheDirty) {
			System.out.println("Using cached value for isPrime(" + this.number + ")");
			return this.cachedIsPrime;
		} else {
			System.out.println("Evaluating isPrime(" + this.number + ")");
			this.cachedIsPrime = true;

			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					this.cachedIsPrime = false;
					break;
				}
			}

			this.isPrimeCacheDirty = false;

			return this.cachedIsPrime;
		}
	}

	public boolean isPerfect() {
		if (!this.isPerfectCacheDirty) {
			System.out.println("Using cached value for isPerfect(" + this.number + ")");
			return this.cachedIsPerfect;
		} else {
			System.out.println("Evaluating isPerfect(" + this.number + ")");
			this.cachedIsPerfect = true;
			int sumDiv = 0;

			for (int i = 1; i <= number / 2; i++) {
				if (number % i == 0) {
					sumDiv += i;
				}
			}

			if (sumDiv != number) {
				this.cachedIsPerfect = false;
			}

			this.isPerfectCacheDirty = false;

			return this.cachedIsPerfect;
		}

	}

	public boolean isMagic() {
		if (!this.isMagicCacheDirty) {
			System.out.println("Using cached value for isMagic(" + this.number + ")");
			return this.cachedIsMagic;
		} else {
			System.out.println("Evaluating isMagic(" + this.number + ")");
			this.cachedIsMagic = false;
			int copyOfNumber = this.number;

			while (copyOfNumber >= 10) {
				copyOfNumber = verifyMagic(copyOfNumber);
			}

			if (copyOfNumber == 3 || copyOfNumber == 7 || copyOfNumber == 9) {
				this.cachedIsMagic = true;
			}

			this.isMagicCacheDirty = false;

			return this.cachedIsMagic;
		}
	}

	private int verifyMagic(int n) {
		int lastDigit;
		int newNumber = 0;
		while (n != 0) {
			lastDigit = n % 10;
			newNumber += lastDigit;
			n /= 10;
		}
		return newNumber;
	}

}
