import { test, expect } from '@playwright/test';

test(
  'draft5',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-023' },
    tag: ['@QADENCE_TC_ID:TC-023'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-password"]').click();
    });

    await test.step('#03 - click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-credentials"]').click();
    });

    await test.step('#04 - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

  }
);

