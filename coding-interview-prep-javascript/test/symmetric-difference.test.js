import sym from './../src/symmetric-difference';

describe('symmetric diff between', () => {
    it.each([
        [
            [1, 2, 3],
            [5, 2, 1, 4],
            [3, 4, 5],
        ],
        [
            [1, 2, 3, 3],
            [5, 2, 1, 4],
            [3, 4, 5],
        ],
        [
            [3, 1, 2, 3],
            [5, 2, 1, 4, 5],
            [3, 4, 5],
        ],
    ])('%j and %j should be %j', (a, b, result) => {
        expect(sym(a, b)).toEqual(result);
    }),
        it.each([
            [
                [1, 2, 5],
                [3, 2, 5],
                [3, 4, 5],
                [1, 4, 5],
            ],
            [
                [1, 2, 5, 1],
                [3, 2, 5],
                [3, 4, 5, 3],
                [1, 4, 5],
            ],
            [
                [1, 2, 5, 1],
                [3, 2, 5, 2],
                [3, 4, 5, 3],
                [1, 4, 5],
            ],
        ])('%j, %j and %j should be %j', (a, b, c, result) => {
            expect(sym(a, b, c)).toEqual(result);
        }),
        it.each([
            [
                [3, 2, 5],
                [2, 1, 5, 7],
                [3, 4, 6],
                [1, 2, 3],
                [2, 3, 4, 6, 7],
            ],
        ])('%j, %j, %j and %j should be %j', (a, b, c, d, result) => {
            expect(sym(a, b, c, d)).toEqual(result);
        });
});
