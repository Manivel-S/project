import { test, expect } from '@playwright/test';

test(
  'TestRun',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-001' },
    tag: ['@QADENCE_TC_ID:TC-001'],
  },
  async ({ page }) => {


    await test.step('navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-container"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-container"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-credentials"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-password"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-container"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="password"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="error"]').getByRole("button").click();
    });

  }
);

