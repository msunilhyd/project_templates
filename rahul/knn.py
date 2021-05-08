import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.datasets import make_blobs

data = make_blobs(n_samples=300, n_features=5, centers=2, cluster_std=6.0, random_state=101)
print(data)

df_feat = pd.DataFrame(data[0], columns=['feature_' + str(i) for i in range(1, 6)])
print(df_feat.head(2))
