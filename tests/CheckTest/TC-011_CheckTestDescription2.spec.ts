import { test, expect } from '@playwright/test';

test(
  'CheckTestDescription2',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-011' },
    tag: ['@QADENCE_TC_ID:TC-011'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - click', async () => {
      await page.locator('[data-test="possport"]').click();
    });

    await test.step('#03 - click', async () => {
      await page.locator('[data-test="password"]').click();
    });

    await test.step('#04 - click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-credentials"]').click();
    });

    await test.step('#05 - click', async () => {
      await page.locator('[data-test="login-container"]').locator('[data-test="login-credentials-container"]').click();
    });

  }
);

