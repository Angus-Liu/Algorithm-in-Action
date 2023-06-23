from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in num_dict:
                return [i, num_dict[diff]]
            else:
                num_dict[num] = i
        return []
