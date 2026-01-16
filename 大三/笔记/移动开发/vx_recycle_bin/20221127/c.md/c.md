# c
## 第一部分 3
```cpp
#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;
int main() {
    vector<int> num;
    int n;
    while (1 == scanf("%d", &n)) {
        while (n) {
            num.push_back(n % 10);
            n /= 10;
        }
        if (num.size() > 5 || num[0] < 0) {
            printf("用户输入不合法");
            continue;
        }
        printf("是%zu位数 ", num.size());
        for (int i : num) {
            printf("%d", i);
        }
        putchar('\n');
        num.clear();
    }
    return 0;
}
```
## 第一部分第四题
```cpp
#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;
int main() {
    int a[4];
    for (int & i : a) cin >> i;
    for (int i = 0; i < 3; i++) {
        for (int j = i; j < 4; j++) {
            if (a[i] > a[j]) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
    for (int i : a) cout << i << endl;
    return 0;
}

```
## 第5题
```cpp
#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
double z(double x, double y) {
    if (x < 0 && y < 0) {
        return exp(x + y);
    } else if ( (x + y) >= 1 && (x + y) < 10) {
        return log(x + y);
    } else {
        return log10(fabs(x + y) + 1);
    }
}
int main() {
    double y1, y2;
    while (2 == scanf("%lf %lf", &y1, &y2)) {
        printf("%.3lf\n", z(y1, y2));
    }
    return 0;
}

```
![](vx_images/241105415239582.png)
## 第二部分第二题
![](vx_images/353745915240284.png)
2．编写程序：根据公式    ，输出 π的值。 
要求： 
（1）变量π为单精度类型，n为整型； 
（2）计算当n的取值分别为20，50 ，100，200时的π值，说明什么问题？ 
```cpp
#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
int main() {

    int n = 0;
    while (1 == scanf("%d", &n)) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / (1.0 * i * i);
        }
        printf("n = %d, pi = %.3lf\n", n , sqrt(6 * sum));
    }
    return 0;
}

```
![](vx_images/467971216250473.png)
（3）修改程序，不给出n值，而改为求π值，直到最后一项的数值小于10-4 为止。 
（4）对修改后的程序，输出π值以及总的项数n。输出格式为：π=值；n=值。
```cpp
#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
int main() {

    double sum = 0, t = 1;
    int i = 2;
    while (t > 1e-4) {
        sum += t;
        t = 1.0 / (i * i);
        i++;
    }
    printf("n = %d, pi = %.3lf\n",i , sqrt(6 * sum));
    return 0;
}

```
![](vx_images/274811016232593.png)
## 第二部分第三题
3．从键盘输入一个0～1000之间的任意整数，输出该整数的所有因子（例如：输入12，其因子为1，2，3，4，6，12）。 
要求： 
（1）采用while循环语句实现。 
（2）输出格式为：Input：12
                 Output：1，2，3，4，6，12  
```cpp
#include <iostream>
#include <vector>
#include <cmath>
#include <cstdio>
using namespace std;
int main() {
    vector<int> factor;
    int n;
    cin >> n;

    factor.push_back(1);
    factor.push_back(n);
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            if (i * i != n) {
                factor.push_back(i);
                factor.push_back(n / i);
            } else {
                factor.push_back(i);
            }
        }
    }
    for (int i = 0; i < factor.size() - 1; i++) {
        for (int j = i; j < factor.size(); j++) {
            if (factor[i] > factor[j]) {
                int t = factor[i];
                factor[i] = factor[j];
                factor[j] = t;
            }
        }
    }

    for (auto i : factor) cout << i << " ";
}

```
![](vx_images/56652016248077.png)
## 思考讨论第5题
```cpp
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> vec { 1,20,30,12,3,5,7,4,6,100,11,8 };
    cout << "( " << vec[0] << " ";
    for (int i = 1; i < vec.size(); i++) {
        if (i == vec.size() - 1) {
            cout << vec[i] << " )";
            break;
        }
        if (vec[i - 1] < vec[i] != vec[i] < vec[i + 1]) {
            cout << vec[i] << " )" << "( " << vec[i] << " ";
        } else {
            cout << vec[i] << " ";
        }
    }
    return 0;
}

```
## 思考讨论第6题
```cpp
#include<iostream>
using namespace std;
#define ull unsigned long long
ull quick_pow(ull a,ull b,ull p)
{
    ull res = 1;
    while (b) {
        if (b&1) res = res*a %p;
        a = a*a %p;
        b >>= 1;
    }
    return res %p;
}
int main()
{
    // 使用 矩阵快速幂算法
    int a = 12,b = 100, p = 1000;
    cout<<quick_pow(a,b,p)<<endl;
    return 0;
}

```
## 打印图形
```cpp
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n = 10;
    for (int i = 0; i <= n; i++) {
        // 打空格
        for (int j = 1; j <= 3 * (n - i); j++) {
            printf(" ");
        }
        // 打印数字
        for (int j = 0; j <= i; j++) {
            printf("%2d ", 2 * j + 1);
        }
        for (int j = i - 1; j >= 0; j--) {
            printf("%2d ", 2 * j + 1);
        }
        putchar('\n');
    }
    return 0;
}

```