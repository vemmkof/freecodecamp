function sym(...args) {
    let symdiff = args[0];
    for (let i = 1; i < args.length; i++) {
        symdiff = getSymDiff(symdiff, args[i]);
    }
    const diff = [...new Set(symdiff)];
    diff.sort();
    return diff;
}

const getSymDiff = (arr1, arr2) => {
    const set1 = new Set(arr1);
    const set2 = new Set(arr2);
    const diff1 = Array.from(set1).filter((x) => !set2.has(x));
    const diff2 = Array.from(set2).filter((x) => !set1.has(x));
    return [...diff1, ...diff2];
};

export default sym;
