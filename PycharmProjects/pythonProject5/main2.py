temps = [28, 31, 33, 35, 27, 26, 25]
for i in range(len(temps)):
    print(temps[i], end=',')

print("-" * 30)

questions = ['name', 'subject', 'color']
answers = ['이순신', '국어', 'blue']
for q, a in zip(questions, answers):
    print(f"What is your {q}? It is {a}")




