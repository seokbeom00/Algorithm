import numpy as np
import random
import time

start_time = time.time()
a = np.random.randint(0, 1001, size=100)
b = np.where(a > 500, 1, 0)
end_time = time.time() - start_time
print(end_time)
