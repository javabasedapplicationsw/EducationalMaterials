# 키워드 인수

def himedia(x, y, z):
    print("x=", x, "y=", y, "z=", z)

himedia(10, 20, 30)
himedia(x=10, y=20, z=30)
himedia(10, y=20, z=30)
himedia(10, 20, z=30)
#himedia(x=10, 20, 30)      -- syntaxError

