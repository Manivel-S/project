import { test, expect } from '@playwright/test';

test(
  'CheckReorder',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-030' },
    tag: ['@QADENCE_TC_ID:TC-030'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

  }
);

