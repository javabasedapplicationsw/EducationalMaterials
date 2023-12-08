import matplotlib.pyplot as plt

X = ["Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"]
y1 = [15.6, 14.2, 16.3, 18.2, 17.1, 20.2, 22.4]
y2 = [20.1, 23.1, 23.8, 25.9, 23.4, 25.1, 26.3]

plt.plot(X, y1, label="Seoul")
plt.plot(X, y2, label="Busan")
plt.xlabel("day")
plt.ylabel("temperature")
plt.legend(loc="upper left")
plt.title("Temperatures of Cities")
plt.show()