#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import random

arr = [x for x in range(1,11)]

result = []



for x in range(1,11):
    j = random.randint(1, 11-x)
    result.append(arr[j])
    arr.remove(arr[j])

print(result)