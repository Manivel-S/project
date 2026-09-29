import { test, expect } from '@playwright/test';

test(
  'testRun',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-001' },
    tag: ['@QADENCE_TC_ID:TC-001'],
  },
  async ({ page }) => {


    await test.step.skip('#01 - Disabled - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

  }
);

