/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (map.has(target - nums[i])) {
            return [map.get(target - nums[i]), i];
        }
        map.set(nums[i], i);
    }
    return [0, 0];
};

function test() {
    console.log(twoSum([2, 7, 11, 15], 9));
}

test();