import { test, expect } from '@playwright/test';

test(
  'ApiCheck',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-041' },
    tag: ['@QADENCE_TC_ID:TC-041'],
  },
  async ({ page, request }) => {

    let data: any;


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - get', async () => {
      // TODO: GET step has no variables
    });

    await test.step('#03 - GET https://www.randomnumberapi.com/api/v1.0/random?min=1&max=100&count=1', async () => {
      const apiResponse3 = await request.fetch('https://www.randomnumberapi.com/api/v1.0/random?min=1&max=100&count=1', {
        method: 'GET',
      });
      const apiResponse3Body = await apiResponse3.json();
      expect(apiResponse3.status()).toBe(200);
      data = apiResponse3Body[0].id;
    });

  }
);

