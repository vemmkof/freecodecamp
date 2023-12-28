module.exports = {
    env: { es6: true, node: true },
    extends: ['eslint:recommended', 'plugin:prettier/recommended'],
    parser: '@babel/eslint-parser',
    parserOptions: {
        sourceType: 'module',
    },
    rules: {
        eqeqeq: ['error', 'always'],
        'no-unused-vars': 'warn',
        semi: ['error', 'always'],
        curly: ['error', 'all'],
        'block-spacing': ['error', 'always'],
        'consistent-return': 'error',
        'arrow-spacing': ['error', { before: true, after: true }],
        'no-var': 'error',
        'prefer-const': 'error',
    },
    overrides: [
        {
            files: ['**/*.test.js'],
            env: {
                jest: true,
            },
        },
    ],
};
