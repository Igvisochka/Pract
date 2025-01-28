#задание 1---------------------------------------------------------------
print("Курс Основы программирования начался")


#задание 2----------------------------------------------------------------
import math

x = -2.235 * 10**-2
y = 2.23
z = 15.221

numerator = math.exp(abs(x - y)) * abs(x - y)**(x + y)

denominator = math.atan(x) + math.atan(z)

term1 = numerator / denominator

term2 = (x**6 + math.log(y)**2)**(1/3)

s = term1 + term2

print(f"Результат: s = {s:.4f}")


#задание 3----------------------------------------------------------------
x = int(input("Введите первое число: "))
y = int(input("Введите второе число: "))
z = int(input("Введите третье число: "))

if x == y == z:
  print(3)
elif x == y or x == z or y == z:
  print(2)
else:
  print(0)


#задание 4----------------------------------------------------------------------------------------------------
n = int(input())
for i in range(1, n + 1):
  for j in range(1, i + 1):
    print(j, end="")
  print()


#задание 5----------------------------------------------------------------
max_count = 0  
current_count = 0  
previous_number = None  

while True:
    number = int(input("Введите натуральное число (0 для завершения): "))
    
    if number == 0:  
        break
    
    if number == previous_number:
        current_count += 1
    else:
        if current_count > max_count:
            max_count = current_count
        current_count = 1  
    
    previous_number = number

if current_count > max_count:
    max_count = current_count

print("Наибольшее количество подряд идущих равных элементов:", max_count)


#задание 6-------------------------------------------------------
text = input("Введите текст: ")
words = text.split()
print(f"В введенной строке {len(words)} слова.")
