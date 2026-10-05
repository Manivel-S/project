import { test, expect } from '@playwright/test';

test(
  'UnsavedEdit',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-029' },
    tag: ['@QADENCE_TC_ID:TC-029'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - hover step', async () => {
      await page.locator('test').hover();
    });

    await test.step('#03 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

  }
);

