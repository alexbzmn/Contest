#include <iostream>

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}

int phi(unsigned int n) {
    unsigned int result = 1;
    for (int i = 2; i < n; i++)
        if (gcd(i, n) == 1)
            result++;
    return result;
}

int phiFast(unsigned int n) {
    int result = n;

    for (unsigned int p = 2; p * p <= n; ++p) {
        if (n % p == 0) {
            while (n % p == 0) {
                n /= p;
            }
            result -= result / p;
        }
    }

    if (n > 1) {
        result -= result / n;
    }
    return result;
}

int main() {

    for (unsigned int i = 0; i < 10; ++i) {
        std::cout << phiFast(i) << std::endl;
    }

    return 0;
}
